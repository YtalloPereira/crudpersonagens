package br.edu.ifpb.dac.crudpersonagens.config;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import br.edu.ifpb.dac.crudpersonagens.business.service.TokenService;
import br.edu.ifpb.dac.crudpersonagens.business.service.UserService;
import br.edu.ifpb.dac.crudpersonagens.model.entity.User;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class TokenFilter extends OncePerRequestFilter{
	
	private TokenService tokenService;
	private UserService userService;
	
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String token = tokenService.get((javax.servlet.http.HttpServletRequest) request);
		// TODO tratamento para exceções do método "doFilterInternal" ?
		if (tokenService.isValid(token)) {
			try {
				authenticate(token);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		filterChain.doFilter(request, response);
		
	}
	
	// coloca o usuário autenticado no contexto do Spring Security
	private void authenticate(String token) throws NumberFormatException, Exception {
		Long userId = tokenService.getUserId(token);
		//TODO comportamento inesperado de User: o retorno da linha abaixo é uma exceção
		User user = userService.findById(userId);

		UsernamePasswordAuthenticationToken authentication = 
		new UsernamePasswordAuthenticationToken(user, null,	user.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}

	

}
