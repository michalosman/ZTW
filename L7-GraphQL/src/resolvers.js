import db from "./db.js";

const Query = {
  users: () => db.users,
  todos: () => db.todos,
  todo: (parent, args, context, info) =>
    db.todos.find((todo) => todo.id == args.id),
  user: (parent, args, context, info) =>
    db.users.find((user) => user.id == args.id),
};

const User = {
  todos: (parent, args, context, info) => {
    return db.todos.filter((todo) => todo.user_id === parent.id);
  },
};

const TodoItem = {
  user: (parent, args, context, info) => {
    return db.users.find((user) => user.id === parent.user_id);
  },
};

export default { Query, User, TodoItem };
