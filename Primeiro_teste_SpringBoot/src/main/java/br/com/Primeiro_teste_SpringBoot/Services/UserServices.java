package br.com.Primeiro_teste_SpringBoot.Services;

import br.com.Primeiro_teste_SpringBoot.Repository.UserRepository;
import br.com.Primeiro_teste_SpringBoot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

@Service
public class UserServices{

    @Autowired
    private UserRepository userRepository;

    /**
     * @return Returns the list of all users
     */
    public List<User> obterTodos(){
        return userRepository.obterTodos();
    }

    /** Method to search for id
     * @return Returns the users according to the id
     * @param id ID of the user to be searched for
     */
    public Optional<User> obterPorId(Integer id){
        return userRepository.obterPorId(id);
    }

    /**
     * Method to add users to the list
     * @param user user to be added
     */
    public User adicionarUsuario(User user){
        return userRepository.adicionarUsuario(user);
    }

    /**
     * Method to delete user id
     * @param id ID of the user to be searched for
     */
    public void deletar(Integer id){
        userRepository.deletar(id);
    }

    /**
     * method to update user
     * @param user user who will be updated
     * @return returns the product that will be updated
     */
    public User atualizar(Integer id,User user){
        user.setId(id);

        return userRepository.atualizar(user);
    }
}
