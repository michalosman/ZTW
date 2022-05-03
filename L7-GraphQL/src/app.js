import { createServer } from "@graphql-yoga/node";
import resolvers from "./resolvers.js";
import typeDefs from "./schema.js";

const server = new createServer({
  schema: {
    typeDefs,
    resolvers,
  },
});

server.start(() => console.log("Server is running on http://localhost:4000"));
