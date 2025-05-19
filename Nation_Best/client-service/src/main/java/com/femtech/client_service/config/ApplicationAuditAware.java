package com.femtech.client_service.config;//package com.femtech.nationBest.config;
//
//
//import com.femtech.nationBest.client.customer.Customer;
//import org.springframework.data.domain.AuditorAware;
//import org.springframework.security.authentication.AnonymousAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//
//import java.util.Optional;
//
//public class ApplicationAuditAware implements AuditorAware<String> {
//    @Override
//    public Optional<String> getCurrentAuditor() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//
//        if (authentication == null ||
//                !authentication.isAuthenticated() ||
//                authentication instanceof AnonymousAuthenticationToken) {
//            return Optional.empty();
//        }
//
//         Customer userPrincipal = (Customer) authentication.getPrincipal();
//
//        return Optional.ofNullable(authentication.getName());
//    }
//}
