import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DestinoService {

    private List<Destino> destinos = new ArrayList<>();
    private long idCounter = 1;

    public Destino cadastrarDestino(Destino destino) {
        destino.setId(idCounter++);
        destinos.add(destino);
        return destino;
    }

    public List<Destino> listarDestinos() {
        return destinos;
    }

    public Optional<Destino> buscarDestinoPorId(Long id) {
        return destinos.stream().filter(d -> d.getId().equals(id)).findFirst();
    }

    public List<Destino> pesquisarDestinos(String nome, String localizacao) {
        List<Destino> resultado = new ArrayList<>();
        for (Destino destino : destinos) {
            if (destino.getNome().contains(nome) || destino.getLocalizacao().contains(localizacao)) {
                resultado.add(destino);
            }
        }
        return resultado;
    }

    public Destino avaliarDestino(Long id, int nota) {
        Destino destino = buscarDestinoPorId(id).orElseThrow(() -> new RuntimeException("Destino não encontrado"));
        destino.adicionarAvaliacao(nota);
        return destino;
    }

    public void excluirDestino(Long id) {
        Destino destino = buscarDestinoPorId(id).orElseThrow(() -> new RuntimeException("Destino não encontrado"));
        destinos.remove(destino);
    }
}
