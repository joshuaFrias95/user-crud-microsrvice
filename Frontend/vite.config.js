import { defineConfig } from 'vite'
import react from "@vitejs/plugin-react"

export default defineConfig({
  base: "/",
  plugins: [react()],
  preview: {
    port: 5173,
    strictPort: true,
  },
  server: {
/*     proxy: {
      '/api': {
        target: 'http://localhost:8080',
        changeOrigin: true,
        rewrite: (path) => path.replace(/^\/api/, ''),
      },
    }, */
    port: 5173,
    strictPort: true,
    host: true,
    origin: "http://0.0.0.0:5173"
  },
})