export default /* GraphQL */ `
  type Query {
    todos: [TodoItem!]
    todo(id: ID!): TodoItem
    users: [User!]
    user(id: ID!): User
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
`;
