import axios from "axios";
import { open, readFile, writeFile } from "fs/promises"

// const users = await fetchUsers();
// const todos = await fetchTodos();
// const modifyUser =  await modifyUser();

async function fetchUsers() {
  try {
    // const users = await axios.get("https://jsonplaceholder.typicode.com/users");
    var users = await readFile("db/users.json", 'utf8')
    users = JSON.parse(users)
    // console.log(users)
    // return users.map(({ id, name, email }) => ({
    //   id: id,
    //   name: name,
    //   email: email,
    // }));
    return users
  } catch (error) {
    throw error;
  }
}

async function fetchTodos() {
  try {
    // const todos = await axios.get("https://jsonplaceholder.typicode.com/todos");
    var todos = await readFile("db/todos.json", 'utf8')
    todos = JSON.parse(todos)
    return todos;
  } catch (error) {
    throw error;
  }
}
async function saveUsers(data){
  await writeFile("db/users.json", JSON.stringify(data), 'utf-8')
}
async function saveTodos(data){
  await writeFile("db/todos.json", JSON.stringify(data), 'utf-8')
}
async function addUser({ name, email }) {
  try {
    // console.log(name,email,login)
    var users = await fetchUsers()
    var nextId = Math.max.apply(Math, users.map(function (o) { return o.id; })) + 1
    users.push({
      id: nextId,
      name: name,
      email: email,
    })
    saveUsers(users)
    return { ok: true };
  } catch (e) {
    throw (e);
  }
}
async function addTodo({ userId, title }) {
  try {
    console.log(userId,title)
    var todos = await fetchTodos()
    var nextId = Math.max.apply(Math, todos.map(function (o) { return o.id; })) + 1
    // var user = users.find(e => e.id = id)
    // var x = []
    todos.push({
      userId: Number.parseInt(userId),
      id: nextId,
      title: title,
      completed:false
    })
    // console.log(users[-1])
    saveTodos(todos)
    return { ok: true };
  } catch (e) {
    throw (e);
  }
}
async function deleteTodo({ id }) {
  try {
    console.log("i",id)
    var todos = await fetchTodos()
    // console.log("l",todos.filter(t => t.id != Number.parseInt(id)))
    todos = todos.filter(t => t.id != Number.parseInt(id))
    await saveTodos(todos)
    return { ok: true };
  } catch (e) {
    throw (e);
  }
}
async function deleteUser({ id }) {
  try {
    console.log("i",id)
    var users = await fetchUsers()
    var todos = await fetchTodos()
    // console.log("l",todos.filter(t => t.id != Number.parseInt(id)))
    users = users.filter(t => t.id != Number.parseInt(id))
    todos = todos.filter(t => t.userId != Number.parseInt(id))
    await saveTodos(todos)
    await saveUsers(users)
    return { ok: true };
  } catch (e) {
    throw (e);
  }
}

export default { fetchUsers, fetchTodos, addUser,addTodo,deleteTodo,deleteUser };
