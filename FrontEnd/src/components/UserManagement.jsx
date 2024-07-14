import React, { useState, useEffect } from 'react';
import axios from 'axios';

const UserManagement = () => {
  const [users, setUsers] = useState([]);
  const [newUser, setNewUser] = useState({ nombre: '', correoElectronico: '' });
  const [editUser, setEditUser] = useState(null);
  const [searchTerm, setSearchTerm] = useState('');
  const [showPassword, setShowPassword] = useState(false);

  useEffect(() => {
    fetchUsers();
  }, []);

  const fetchUsers = async () => {
    try {
      const response = await axios.get('http://localhost:8080/usuarios/findAll');
      setUsers(response.data);
    } catch (error) {
      console.error('Error fetching users:', error);
    }
  };

  // Filtrar usuarios según el término de búsqueda
  const filteredUsers = users.filter(user => (
    user?.nombre?.toLowerCase().includes(searchTerm.toLowerCase()) ||
    user?.apellido?.toLowerCase().includes(searchTerm.toLowerCase()) ||
    user?.contrasena?.toLowerCase().includes(searchTerm.toLowerCase()) ||
    user?.correoElectronico?.toLowerCase().includes(searchTerm.toLowerCase())
  ));


  const handleCreateUser = async () => {
    try {
      await axios.post('http://localhost:8080/usuarios/create', newUser);
      fetchUsers();
      setNewUser({ nombre: '', apellido: '', correoElectronico: '' });
    } catch (error) {
      console.error('Error creating user:', error);
    }
  };

  const handleUpdateUser = async (id) => {
    try {
      await axios.put(`http://localhost:8080/usuarios/update/${id}`, editUser);
      fetchUsers();
      setEditUser(null);
    } catch (error) {
      console.error('Error updating user:', error);
    }
  };

  const handleDeleteUser = async (id) => {
    try {
      await axios.delete(`http://localhost:8080/usuarios/delete/${id}`);
      fetchUsers();
    } catch (error) {
      console.error('Error deleting user:', error);
    }
  };

  return (
    <div className="container mx-auto p-4">
      <h1 className="text-2xl font-bold mb-4">User Management</h1>

      <div className="mb-4">
        <h2 className="text-xl font-semibold">Search Users</h2>
        <input
          type="text"
          placeholder="Search by Name or Email"
          value={searchTerm}
          onChange={(e) => setSearchTerm(e.target.value)}
          className="border p-2"
        />
      </div>

      <div>
        <h2 className="text-xl font-semibold">User List</h2>
        <ul className="list-disc pl-5">
          {filteredUsers.map((user) => (
            <li key={user.id} className="mb-2">
              {editUser && editUser.id === user.id ? (
                <div>
                  <input
                    type="text"
                    value={editUser.nombre}
                    onChange={(e) => setEditUser({ ...editUser, nombre: e.target.value })}
                    className="border p-2 mr-2"
                  />
                   <input
                    type={showPassword ? 'text' : 'password'} // Cambia dinámicamente entre 'text' y 'password'
                    value={editUser.contrasena}
                    onChange={(e) => setEditUser({ ...editUser, contrasena: e.target.value })}
                    className="border p-2"
                  />
                  <button onClick={() => setShowPassword(!showPassword)} className="mr-4 p-2 bg-gray-200 hover:bg-gray-300 text-gray-800">
                    {showPassword ? 'Hide' : 'Show'}
                  </button>
                  <input
                    type="email"
                    value={editUser.correoElectronico}
                    onChange={(e) => setEditUser({ ...editUser, correoElectronico: e.target.value })}
                    className="border p-2 mr-2"
                  />
                  <button onClick={() => handleUpdateUser(user.id)} className="bg-green-500 text-white p-2">Save</button>
                  <button onClick={() => setEditUser(null)} className="bg-gray-500 text-white p-2 ml-2">Cancel</button>
                </div>
              ) : (
                <div>
                  <span>{user.nombre} - {user.correoElectronico}</span>
                  <button onClick={() => setEditUser(user)} className="bg-yellow-500 text-white p-2 ml-2">Edit</button>
                  <button onClick={() => handleDeleteUser(user.id)} className="bg-red-500 text-white p-2 ml-2">Delete</button>
                </div>
              )}
            </li>
          ))}
        </ul>
      </div>
    </div>
  );
};

export default UserManagement;
