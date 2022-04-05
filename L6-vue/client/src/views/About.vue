<template>
  <div>
    <router-link to="/"><strong>Go Back</strong></router-link>
    <h3>Phone</h3>
    <p>+ 48 123 456 789</p>
    <h3>Email</h3>
    <p>randomstring@gmail.com</p>
  </div>
</template>

<script>
export default {
  name: 'About',
}
</script>

<style scoped>
div {
  text-align: center;
}

h3 {
  margin-top: 20px;
}
</style>
