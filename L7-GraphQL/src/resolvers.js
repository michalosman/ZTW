import db from "./db.js";

const Query = {
  users: () => db.getUsers(),
  user: (_, { id }) => db.getUser(id),
  todos: () => db.getTodos(),
  todo: (_, { id }) => db.getTodo(id),
};

const User = {
  todos: (parent, _) => db.getUserTodos(parent.id),
};

const TodoItem = {
  user: (parent, _) => db.getTodoUser(parent.userId),
};

const Mutation = {
  addUser: (_, { name, email }) => db.addUser(name, email),
  deleteUser: (_, { id }) => db.deleteUser(id),
  addTodo: (_, { userId, title }) => db.addTodo(userId, title),
  deleteTodo: (_, { id }) => db.deleteTodo(id),
};

export default { Query, User, TodoItem, Mutation };
