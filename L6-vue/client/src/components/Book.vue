<template>
  <div
    @dblclick="$emit('toggle-read', book.id)"
    :class="[book.read ? 'read' : '', 'book']"
  >
    <h3>
      {{ book.title }}
      <i @click="$emit('delete-book', book.id)" class="fas fa-times"></i>
    </h3>
    <p>{{ book.author }}</p>
    <p>{{ book.pages }} pages</p>
  </div>
</template>

<script>
export default {
  name: 'Book',
  props: {
    book: Object,
  },
}
</script>

<style scope>
.fas {
  color: red;
}
.book {
  background: #f4f4f4;
  margin: 5px;
  padding: 10px 20px;
  cursor: pointer;
  user-select: none;
}
.book.read {
  opacity: 0.3;
}
.book h3 {
  display: flex;
  align-items: center;
  justify-content: space-between;
}
</style>
