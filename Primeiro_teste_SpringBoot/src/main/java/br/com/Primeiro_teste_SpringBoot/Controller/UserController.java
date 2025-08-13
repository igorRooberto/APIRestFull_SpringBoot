package br.com.Primeiro_teste_SpringBoot.Controller;

import br.com.Primeiro_teste_SpringBoot.Repository.UserRepository;
import br.com.Primeiro_teste_SpringBoot.Services.UserServices;
import br.com.Primeiro_teste_SpringBoot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    private UserServices userServices;

    @GetMapping
    public List<User> obterTodos(){
        return userServices.obterTodos();
    }

    @PostMapping
    public User adicionar(@RequestBody User user){
        return userServices.adicionarUsuario(user);
    }

    @GetMapping("/{id}")
    public Optional<User> obterPorId(@PathVariable Integer id){
        return userServices.obterPorId(id);
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Integer id){
        userServices.deletar(id);
        return "O usuário foi removido com sucesso!";
    }

    @PutMapping("/{id}")
    public User atualizar(@RequestBody User user,@PathVariable Integer id){
        return userServices.atualizar(id,user);
    }
}
