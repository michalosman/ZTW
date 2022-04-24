import axios from "axios";

const users = await fetchUsers();
const todos = await fetchTodos();

async function fetchUsers() {
  try {
    const users = await axios.get("https://jsonplaceholder.typicode.com/users");
    return users.data.map(({ id, name, email, username }) => ({
      id: id,
      name: name,
      email: email,
      login: username,
    }));
  } catch (error) {
    throw error;
  }
}

async function fetchTodos() {
  try {
    const todos = await axios.get("https://jsonplaceholder.typicode.com/todos");
    return todos.data;
  } catch (error) {
    throw error;
  }
}

export default { users, todos };
