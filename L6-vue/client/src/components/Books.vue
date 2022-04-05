<template>
  <div v-for="book in books" :key="book.id">
    <Book
      v-if="!book.read"
      @toggle-read="$emit('toggle-read', book.id)"
      @delete-book="$emit('delete-book', book.id)"
      :book="book"
    />
  </div>
  <div v-for="book in books" :key="book.id">
    <Book
      v-if="book.read"
      @toggle-read="$emit('toggle-read', book.id)"
      @delete-book="$emit('delete-book', book.id)"
      :book="book"
    />
  </div>
</template>

<script>
import Book from './Book.vue'

export default {
  name: 'Books',
  components: { Book },
  props: {
    books: Array,
  },
  emits: ['delete-book', 'toggle-read'],
}
</script>
