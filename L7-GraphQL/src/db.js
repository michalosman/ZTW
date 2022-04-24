import axios from "axios";

const users = await fetchUsers();
const todos = await fetchTodos();
// const todos = [
//   { id: 1, title: "Naprawić samochód", completed: false, user_id: 3 },
//   { id: 2, title: "Posprzątać garaż", completed: true, user_id: 3 },
//   { id: 3, title: "Napisać e-mail", completed: false, user_id: 3 },
//   { id: 4, title: "Odebrać buty", completed: false, user_id: 2 },
//   { id: 5, title: "Wysłać paczkę", completed: true, user_id: 2 },
//   { id: 6, title: "Zamówic kuriera", completed: false, user_id: 3 },
// ];

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
