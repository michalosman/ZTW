<template>
  <header>
    <h1>{{ title }}</h1>
  </header>
</template>

<script>
export default {
  name: 'Header',
  props: {
    title: String,
  },
}
</script>

<style>
header {
  text-align: center;
  margin-bottom: 20px;
}
h1 {
  font-size: 40px;
}
</style>
