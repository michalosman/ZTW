import { readFile, writeFile } from "fs/promises";

//* Users

async function saveUsers(data) {
  try {
    await writeFile("db/users.json", JSON.stringify(data), "utf-8");
  } catch (error) {
    console.log(error);
  }
}

async function getUsers() {
  try {
    const users = await readFile("db/users.json", "utf8");
    return JSON.parse(users);
  } catch (error) {
    console.log(error);
    return [];
  }
}

async function getUser(id) {
  try {
    const users = await getUsers();
    return users.find((user) => user.id === Number.parseInt(id));
  } catch (error) {
    console.log(error);
    return null;
  }
}

async function getUserTodos(id) {
  try {
    const todos = await getTodos();
    return todos.filter((todo) => todo.userId === id);
  } catch (error) {
    console.log(error);
    return [];
  }
}

async function addUser(name, email) {
  try {
    const users = await getUsers();

    users.push({
      id: getNextId(users),
      name,
      email,
    });

    saveUsers(users);
    return { ok: true };
  } catch (error) {
    console.log(error);
    return { ok: false };
  }
}

async function deleteUser(id) {
  try {
    const users = await getUsers();
    const todos = await getTodos();

    const newTodos = todos.filter(
      (todo) => todo.userId !== Number.parseInt(id)
    );
    const newUsers = users.filter((user) => user.id !== Number.parseInt(id));

    await saveTodos(newTodos);
    await saveUsers(newUsers);

    return { ok: true };
  } catch (error) {
    console.log(error);
    return { ok: false };
  }
}

//* Todos

async function saveTodos(data) {
  try {
    await writeFile("db/todos.json", JSON.stringify(data), "utf-8");
  } catch (error) {
    console.log(error);
  }
}

async function getTodos() {
  try {
    const todos = await readFile("db/todos.json", "utf8");
    return JSON.parse(todos);
  } catch (error) {
    console.log(error);
    return [];
  }
}

async function getTodo(id) {
  try {
    const todos = await getTodos();
    return todos.find((todo) => todo.id === Number.parseInt(id));
  } catch (error) {
    console.log(error);
    return null;
  }
}

async function getTodoUser(id) {
  try {
    const users = await getUsers();
    return users.find((user) => user.id === id);
  } catch (error) {
    console.log(error);
    return null;
  }
}

async function addTodo(userId, title) {
  try {
    const todos = await getTodos();

    todos.push({
      id: getNextId(todos),
      title,
      completed: false,
      userId: Number.parseInt(userId),
    });

    saveTodos(todos);
    return { ok: true };
  } catch (error) {
    console.log(error);
    return { ok: false };
  }
}

async function deleteTodo(id) {
  try {
    const todos = await getTodos();
    await saveTodos(todos.filter((todo) => todo.id !== Number.parseInt(id)));
    return { ok: true };
  } catch (error) {
    console.log(error);
    return { ok: false };
  }
}

//* Utils

function getNextId(array) {
  return Math.max(...array.map((element) => element.id)) + 1;
}

export default {
  getUsers,
  getUser,
  getUserTodos,
  addUser,
  deleteUser,
  getTodos,
  getTodo,
  getTodoUser,
  addTodo,
  deleteTodo,
};
