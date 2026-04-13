Cryptography ToolkitA Java CLI application for symmetric encryption, asymmetric encryption, and hash functions.Team Members & Responsibilities#NameBranchFeature1 (Lead)[Tên Nhóm Trưởng]mainMerge code, Project Report, Coordination2[Tên Thành Viên 1]feature/main-menuMain Menu CLI, Input Validation3[Tên Thành Viên 2]feature/symmetricDES, 3DES, AES (128/256)4[Tên Thành Viên 3]feature/rsaRSA key generation, Encrypt/Decrypt5[Tên Thành Viên 4]feature/hashMD5, SHA-256Libraries Usedjavax.crypto — Symmetric encryption (DES, 3DES, AES)java.security — RSA, MessageDigest (MD5, SHA-256)All libraries are part of the Java Standard Library — no external dependencies needed.Project Structuresrc/main/java/org/example/
├── Main.java                    # Entry point (Thành viên 1)
├── symmetric/                   # (Thành viên 2)
│   ├── DESService.java          
│   ├── TripleDESService.java    
│   └── AESService.java         
├── asymmetric/                  # (Thành viên 3)
│   └── RSAService.java          
└── hash/                        # (Thành viên 4)
└── HashService.java         
How to RunBash# Build
mvn compile

# Run
mvn exec:java -Dexec.mainClass="org.example.Main"
Features1. Main Menu (Thành viên 1)CLI-based interactive interface.Robust input handling for encryption modes and data.2. Symmetric Encryption (Thành viên 2)DES/3DES: ECB and CBC modes.AES: 16-byte (128-bit) or 32-byte (256-bit) keys, CBC mode.Supports manual key input or auto-generated random keys.3. Asymmetric Encryption - RSA (Thành viên 3)RSA 2048-bit key pair generation.Public Key Encryption & Private Key Decryption.Uses OAEP padding with SHA-256 for modern security.4. Hash Functions (Thành viên 4)MD5: Fast 128-bit hash.SHA-256: Secure 256-bit hash.Outputs results in Hexadecimal format.Security NoteMD5 and DES are included for educational purposes only as they are cryptographically broken. For any real-world application, please use AES-256 and SHA-256 or higher.