// package com.sp.backend.security;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

// import com.sp.backend.service.CustomUserDetailsService;

// import jakarta.servlet.FilterChain;
// import jakarta.servlet.ServletException;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;

// import java.io.IOException;

// public class JWTFilter extends UsernamePasswordAuthenticationFilter {

//     @Autowired
//     private JWTUtil jwtUtil;

//     @Override
//     public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
//             throws IOException, ServletException {
//         String authHeader = request.getHeader("Authorization");
//         String username = null;
//         String token = null;

//         if (authHeader != null && authHeader.startsWith("Bearer ")) {
//             token = authHeader.substring(7);
//             username = jwtUtil.getUsername(token);
//         }

//         if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//             UserDetails userDetails = CustomUserDetailsService.loadUserByUsername(username);
//             if (jwtUtil.validateToken(token, username)) {
//                 // Create and set authentication object in SecurityContext
//                 UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
//                     userDetails, null, userDetails.getAuthorities());
//                 SecurityContextHolder.getContext().setAuthentication(auth);
//             }
//         }

//         chain.doFilter(request, response);
//     }
// }
