import React from "react"
import Link from "gatsby-link"
import { graphql } from "gatsby"
import data from "../pages/data"

const Posts = (/*{data}*/) => {
  return (
    <div>
      {data.allMarkdownRemark.edges.map(({ node }) => (
        <div key={node.id} className="article-box">
          <Link to="/" style={{ textDecoration: "none", color: "inherit" }}>
            <h3 className="title">{node.frontmatter.title}</h3>
          </Link>
          <p className="author">
            Author: <i>{node.frontmatter.author}</i>
          </p>
          <p className="date">
            {node.frontmatter.date} {node.frontmatter.timeToRead}min read
          </p>
          <p className="excerpt">{node.frontmatter.text}</p>
        </div>
      ))}
    </div>
  )
}
export default Posts

export const query = graphql`
  query HomePageQuery {
    allMarkdownRemark {
      totalCount
      edges {
        node {
          frontmatter {
            title
            date
            author
            timeToRead
            text
          }
        }
      }
    }
  }
`
