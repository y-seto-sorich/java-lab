<template>
  <div>
    <h1>TODO List</h1>
    <div v-if="loading">Loading TODOs...</div>
    <ul v-else-if="todos.length > 0">
      <li v-for="todo in todos" :key="todo.id">
        {{ todo.title }} <span v-if="todo.completed">(Completed)</span>
      </li>
    </ul>
    <div v-else>No TODOs yet!</div>
  </div>
</template>

<script lang="ts">
import { defineComponent, ref, onMounted } from "vue";
import { Todo } from "@/types/todo";
import axios from "axios";

export default defineComponent({
  name: "TodoList",
  setup() {
    const todos = ref<Todo[]>([]);
    const loading = ref(false);
    const API_BASE_URL = "http://localhost:8080/api"; // バックエンドのAPIベースURL

    const fetchTodos = async () => {
      loading.value = true;
      try {
        const response = await axios.get<Todo[]>(`${API_BASE_URL}/todos`);
        todos.value = response.data;
      } catch (error) {
        console.error("Error fetching TODOs:", error);
        // エラー処理 (例: エラーメッセージの表示)
      } finally {
        loading.value = false;
      }
    };

    onMounted(() => {
      fetchTodos();
    });

    return {
      todos,
      loading,
    };
  },
});
</script>
