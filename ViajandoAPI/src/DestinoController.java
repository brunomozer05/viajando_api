import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/destinos")
public class DestinoController {

    private final DestinoService destinoService;

    @Autowired
    public DestinoController(DestinoService destinoService) {
        this.destinoService = destinoService;
    }

    @PostMapping
    public Destino cadastrarDestino(@RequestBody Destino destino) {
        return destinoService.cadastrarDestino(destino);
    }

    @GetMapping
    public List<Destino> listarDestinos() {
        return destinoService.listarDestinos();
    }

    @GetMapping("/pesquisar")
    public List<Destino> pesquisarDestinos(@RequestParam(required = false) String nome,
                                           @RequestParam(required = false) String localizacao) {
        return destinoService.pesquisarDestinos(nome, localizacao);
    }

    @GetMapping("/{id}")
    public Destino visualizarDestino(@PathVariable Long id) {
        return destinoService.buscarDestinoPorId(id)
                .orElseThrow(() -> new RuntimeException("Destino não encontrado"));
    }

    @PatchMapping("/{id}/avaliar")
    public Destino avaliarDestino(@PathVariable Long id, @RequestParam int nota) {
        if (nota < 1 || nota > 10) {
            throw new IllegalArgumentException("Nota deve estar entre 1 e 10");
        }
        return destinoService.avaliarDestino(id, nota);
    }

    @DeleteMapping("/{id}")
    public void excluirDestino(@PathVariable Long id) {
        destinoService.excluirDestino(id);
    }
}
