<template>
  <form @submit="onSubmit" class="add-form">
    <div class="form-control">
      <label>Title</label>
      <input v-model="title" type="text" name="title" />
    </div>
    <div class="form-control">
      <label>Author</label>
      <input v-model="author" type="text" name="author" />
    </div>
    <div class="form-control">
      <label>Pages</label>
      <input v-model="pages" type="number" name="pages" />
    </div>
    <div class="form-control form-control-check">
      <label>Have you read it?</label>
      <input v-model="read" type="checkbox" name="read" />
    </div>
    <input type="submit" value="Add book" class="btn btn-block" />
  </form>
</template>

<script>
export default {
  name: 'AddBook',
  data() {
    return {
      title: '',
      author: '',
      pages: 0,
      read: false,
    }
  },
  methods: {
    onSubmit(e) {
      e.preventDefault()

      if (!this.title || !this.author || !this.pages) {
        alert('You have to fill all of the fields')
        return
      }

      const newBook = {
        title: this.title,
        author: this.author,
        pages: this.pages,
        read: this.read,
      }

      this.$emit('add-book', newBook)

      this.title = ''
      this.author = ''
      this.pages = 0
      this.read = false
    },
  },
}
</script>

<style scoped>
.add-form {
  margin-bottom: 40px;
}
.form-control {
  margin: 20px 0;
}
.form-control label {
  display: block;
}
.form-control input {
  width: 100%;
  height: 40px;
  padding: 3px 7px;
  margin-top: 5px;
  font-size: 17px;
}
.form-control-check {
  display: flex;
  align-items: center;
  justify-content: center;
}
.form-control-check input {
  height: 20px;
  width: 20px;
  margin-top: 0;
  margin-left: 10px;
}
</style>
