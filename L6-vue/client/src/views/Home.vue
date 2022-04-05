<template>
  <AddBook @add-book="addBook" />
  <Books
    @toggle-read="toggleRead"
    @delete-book="deleteBook"
    :books="books"
  ></Books>
</template>

<script>
import AddBook from '../components/AddBook.vue'
import Books from '../components/Books.vue'

export default {
  name: 'Home',
  components: { Books, AddBook },
  data() {
    return {
      books: [],
    }
  },
  methods: {
    async addBook(book) {
      const res = await fetch('http://localhost:8080/books', {
        method: 'POST',
        headers: {
          'Content-type': 'application/json',
        },
        body: JSON.stringify(book),
      })
      const data = await res.json()
      this.books = [...this.books, data]
    },
    async deleteBook(id) {
      if (confirm('Are you sure?')) {
        const res = await fetch(`http://localhost:8080/books/${id}`, {
          method: 'DELETE',
        })
        this.books = this.books.filter((book) => book.id !== id)
      }
    },
    async toggleRead(id) {
      const bookToToggle = await this.fetchBook(id)
      const updBook = { ...bookToToggle, read: !bookToToggle.read }

      const res = await fetch(`http://localhost:8080/books`, {
        method: 'PUT',
        headers: {
          'Content-type': 'application/json',
        },
        body: JSON.stringify(updBook),
      })
      const data = await res.json()

      this.books = this.books.map((book) =>
        book.id === id ? { ...book, read: data.read } : book
      )
    },
    async fetchBooks() {
      const res = await fetch('http://localhost:8080/books')
      const data = await res.json()
      return data
    },
    async fetchBook(id) {
      const res = await fetch(`http://localhost:8080/books/${id}`)
      const data = await res.json()
      return data
    },
  },
  async created() {
    this.books = await this.fetchBooks()
  },
}
</script>
