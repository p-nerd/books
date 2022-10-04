package com.shihabmahamud.eshoppers.service

import com.shihabmahamud.eshoppers.domain.User
import com.shihabmahamud.eshoppers.dto.LoginDTO
import com.shihabmahamud.eshoppers.dto.UserDTO
import com.shihabmahamud.eshoppers.repository.UserRepository
import com.shihabmahamud.eshoppers.exceptions.UserNotFoundException
import java.nio.charset.StandardCharsets
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

class UserServiceImpl(private val userRepository: UserRepository) : UserService {
    override fun saveUser(userDTO: UserDTO) {
        val user = User(
            userDTO.username,
            userDTO.email,
            encryptPassword(userDTO.password),
            userDTO.firstname,
            userDTO.lastname
        )
        userRepository.save(user)
    }

    override fun isNotUniqueUsername(userDTO: UserDTO): Boolean {
        val user = userRepository.findOneByUsername(userDTO.username)
        return user != null
    }

    override fun isNotUniqueEmail(userDTO: UserDTO): Boolean {
        val user = userRepository.findOneByEmail(userDTO.email)
        return user != null
    }

    override fun verifyUser(loginDTO: LoginDTO): User {
        val user = userRepository.findOneByUsername(loginDTO.username)
            ?: throw UserNotFoundException("User not found by " + loginDTO.username)

        val encrypted = encryptPassword(loginDTO.password)

        if (user.password != encrypted)
            throw UserNotFoundException("Incorrect username password")

        return user
    }

    private fun encryptPassword(password: String): String? {
        return try {
            val digest = MessageDigest.getInstance("SHA-256")
            val bytes = digest.digest(password.toByteArray(StandardCharsets.UTF_8))
            bytesToHex(bytes)
        } catch (e: NoSuchAlgorithmException) {
            throw RuntimeException("Unable to encrypt password", e)
        }
    }

    private fun bytesToHex(hash: ByteArray): String {
        val hexString = StringBuilder()
        for (b in hash) {
            val hex = Integer.toHexString(0xff and b.toInt())
            if (hex.length == 1) {
                hexString.append('0')
            }
            hexString.append(hex)
        }
        return hexString.toString()
    }
}