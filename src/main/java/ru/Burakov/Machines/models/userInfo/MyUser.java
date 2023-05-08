package ru.Burakov.Machines.models.userInfo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "USERS")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MyUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_info_role", joinColumns = @JoinColumn(name = "user_info_id"))
    @Column(name = "role")
    @ElementCollection(fetch = FetchType.EAGER)
    private List<Role> roles;
    private boolean enabled;
}
