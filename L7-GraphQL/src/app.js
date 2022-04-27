import { createServer } from "@graphql-yoga/node";
import resolvers from "./resolvers.js";
import typeDefs from "./schema.js";
const opts = {
  port: 7777,
}
const server = new createServer({
  schema: {
    typeDefs,
    resolvers,
  },
  port: 7777
});


server.start(() => console.log("Server is running on http://localhost:4000"));
