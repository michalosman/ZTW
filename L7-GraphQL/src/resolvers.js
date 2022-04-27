import db from "./db.js";

const Query = {
  users: () => db.fetchUsers(),
  todos: () => db.fetchTodos(),
  todo: async(_,{id}) => {
    var t = await db.fetchTodos()
    return t.find((todo) => todo.id === Number.parseInt(id))
  },
  user: async (_, { id }) => {
    console.log(id);
    var u = await db.fetchUsers();
    return u.find((user) => user.id === Number.parseInt(id));
    // return  db.fetchUsers()[0]
  },
};

const User = {
  todos: async (parent, args, context, info) => {
    var t = await db.fetchTodos();
    // console.log("s",parent.id,t.filter((todo) => todo.userId === parent.id))
    return t.filter((todo) => todo.userId === parent.id);
  },
};

const TodoItem = {
  user: async(parent, args, context, info) => {
    var u = await db.fetchUsers()

    return u.find((user) => user.id === parent.userId);
  },
};
const Mutation = {
  addUser: async (_, args) => { return db.addUser(args) },
  addTodo: async (_, args) => { return db.addTodo(args) },
  deleteTodo: async (_, args) => { return db.deleteTodo(args) },
  deleteUser: async (_, args) => { return db.deleteUser(args) },
  // addUser:async (_,{login})=>{ return {ok:true}}
}

export default { Query, User, TodoItem, Mutation };
