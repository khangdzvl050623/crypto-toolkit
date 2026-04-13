# Cryptography Toolkit

A Java CLI application for symmetric encryption, asymmetric encryption, and hash functions.

## Team Members
| # | Name                     | Branch | Feature |
|---|--------------------------|--------|---------|
| 1 | [Khang Vĩnh nhóm trưởng] | `main` | Merge code, README, report |
| 2 | [Vĩnh Khang]             | `feature/main-menu` | Main menu (CLI) |
| 3 | [Tuấn Kiệt]              | `feature/des-aes` | DES (ECB/CBC), AES-128/256 (CBC) |
| 4 | [Bảo Khanh]              | `feature/rsa` | RSA key generation, encrypt, decrypt |
| 5 | [Hoàng Long]             | `feature/hash` | MD5, SHA-256 |

## Libraries Used 
- `javax.crypto` — Symmetric encryption (DES, 3DES, AES)
- `java.security` — RSA, MessageDigest (MD5, SHA-256)
- All libraries are part of the **Java Standard Library** — no external dependencies needed.

## Project Structure
src/main/java/org/example/
├── Main.java                    # Entry point, CLI menu
├── symmetric/
│   ├── DESService.java          # DES ECB/CBC
│   └── AESService.java          # AES-128/256 CBC
├── asymmetric/
│   └── RSAService.java          # RSA 2048-bit
└── hash/
└── HashService.java         # MD5, SHA-256

## How to Run
```bash
# Build
mvn compile

# Run
mvn exec:java -Dexec.mainClass="org.example.Main"
```

## Features
### 1. Symmetric Encryption
- **DES**: 8-byte key, ECB and CBC modes
- **AES**: 16-byte (AES-128) or 32-byte (AES-256) key, CBC mode
- Supports manual key input or auto-generated random key

### 2. Asymmetric Encryption (RSA)
- RSA 2048-bit key pair generation
- Encrypt with Public Key → Ciphertext
- Decrypt with Private Key → Plaintext
- Uses OAEP padding with SHA-256

### 3. Hash Functions
- MD5 (128-bit output)
- SHA-256 (256-bit output)
- Returns hex digest string

## Note
MD5 and DES are included for **educational purposes only** and are not recommended for production use.