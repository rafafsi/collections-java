package br.com.dio.collection.map;

import java.util.Objects;

public class Livro {
        private String nome;
        private Integer páginas;

        public Livro(String nome, Integer páginas) {
            this.nome = nome;
            this.páginas = páginas;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public Integer getPáginas() {
            return páginas;
        }

        public void setPáginas(Integer páginas) {
            this.páginas = páginas;
        }

        @Override
        public String toString() {
            return "Livro{" +
                    "nome='" + nome + '\'' +
                    ", páginas=" + páginas +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            br.com.dio.collection.map.Livro livros = (br.com.dio.collection.map.Livro) o;
            return Objects.equals(nome, livros.nome) && Objects.equals(páginas, livros.páginas);
        }

        @Override
        public int hashCode() {
            return Objects.hash(nome, páginas);
        }
    }
