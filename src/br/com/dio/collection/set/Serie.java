package br.com.dio.collection.set;

import java.util.Objects;

public class Serie implements Comparable<Serie> {
        private String nome;
        private String genero;
        private Integer tempoEpisodio;

        public Serie(String nome, String genero, Integer tempoEpisodio) {
            this.nome = nome;
            this.genero = genero;
            this.tempoEpisodio = tempoEpisodio;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getGenero() {
            return genero;
        }

        public void setGenero(String genero) {
            this.genero = genero;
        }

        public Integer getTempoEpisodio() {
            return tempoEpisodio;
        }

        public void setTempoEpisodio(Integer tempoEpisodio) {
            this.tempoEpisodio = tempoEpisodio;
        }

        @Override
        public String toString() {
            return "{" +
                    "nome='" + nome + '\'' +
                    ", genero='" + genero + '\'' +
                    ", tempoEpisodio=" + tempoEpisodio +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            br.com.dio.collection.set.Serie serie = (br.com.dio.collection.set.Serie) o;
            return Objects.equals(nome, serie.nome) && Objects.equals(genero, serie.genero) && Objects.equals(tempoEpisodio, serie.tempoEpisodio);
        }
        //é imprescindível subescrever o equals e hashcode quando eu uso a implementação q tenha hash
        @Override
        public int hashCode() {
            return Objects.hash(nome, genero, tempoEpisodio);
        }


    @Override
    public int compareTo(Serie serie) {
            int tempoEpisodio = Integer.compare(this.getTempoEpisodio(), serie.getTempoEpisodio());
            if (tempoEpisodio != 0) return tempoEpisodio;
            return this.getGenero().compareTo(serie.getGenero());
    }
}
