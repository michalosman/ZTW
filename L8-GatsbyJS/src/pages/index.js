import React from "react"
import PropTypes from "prop-types"
import Helmet from "react-helmet"
import Header from "../components/Header"
import Posts from "../components/Posts"
import "./index.css"

const TemplateWrapper = ({ children }) => (
  <div>
    <Helmet
      title="Static Blog"
      meta={[
        { name: "description", content: "Sample" },
        { name: "keywords", content: "sample, something" },
      ]}
    />
    <Header />
    <Posts />
  </div>
)

TemplateWrapper.propTypes = {
  children: PropTypes.func,
}

export default TemplateWrapper
