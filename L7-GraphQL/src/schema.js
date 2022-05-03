export default /* GraphQL */ `
  type Query {
    todos: [TodoItem!]
    todo(id: ID!): TodoItem
    users: [User!]
    user(id: ID!): User
  }

  type Mutation {
    addUser(name: String!, email: String!): DeleteResponse
    addTodo(userId: ID!, title: String!): DeleteResponse
    deleteTodo(id: ID!): DeleteResponse
    deleteUser(id: ID!): DeleteResponse
  }

  type User {
    id: ID!
    name: String!
    email: String!
    login: String!
    todos: [TodoItem!]!
  }

  type TodoItem {
    id: ID!
    title: String!
    completed: Boolean!
    user: User!
  }

  type DeleteResponse {
    ok: Boolean!
  }
`;
