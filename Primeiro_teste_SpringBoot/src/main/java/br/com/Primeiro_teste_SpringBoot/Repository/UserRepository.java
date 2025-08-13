package br.com.Primeiro_teste_SpringBoot.Repository;

import br.com.Primeiro_teste_SpringBoot.model.User;
import br.com.Primeiro_teste_SpringBoot.model.exception.ResourceNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {

    List<User> Users = new ArrayList<>();
    private Integer ultimoId = 0;

    /**
     * @return Returns the list of all users
     */
    public List<User> obterTodos(){
        return Users;
    }
    /** Method to search for id
     * @return Returns the users according to the id
     * @param id ID of the user to be searched for
     */
    public Optional<User> obterPorId(Integer id){
        return Users
                .stream()
                .filter(User -> User.getId() == id)
                .findFirst();
    }

    /**
     * Method to add users to the list
     * @param user user to be added
     */
    public User adicionarUsuario(User user){
        ultimoId++;
        user.setId(ultimoId);
        Users.add(user);
        return user;
    }

    /**
     * Method to delete user id
     * @param id ID of the user to be searched for
     */
    public void deletar(Integer id){
        Users.removeIf(user -> user.getId() == id);
    }

    /**
     * method to update user
     * @param user user who will be updated
     * @return returns the product that will be updated
     */
    public User atualizar(User user){
        Optional<User> userEncontrado = obterPorId(user.getId());

        if(userEncontrado.isEmpty()){
            throw new ResourceNotFoundException("Produto não pode ser atualizado pois não existe!");
        }

        deletar(user.getId());

        Users.add(user);

        return user;
    }
}
