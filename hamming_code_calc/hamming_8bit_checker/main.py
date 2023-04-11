###############################
# 12-bit Hamming Code Checker #
# by Nikodem Przybyszewski    #
# Method according to UWM     #
# lecturers.                  #
###############################

n = -1
while n < 0 or n > 4095:
    print("This calculator is designed for 12-bit codes.\n")
    n = int(input('Enter a number (0 - 4095): '))

# Transform into binary
n_bin: str = bin(n)

# Format given number
n_bin = n_bin.replace("0b", "")
while len(n_bin) < 12:
    n_bin = '0' + n_bin

# Create a copy in case the code needs to be corrected
n_bin_cpy = n_bin

# Extract information and check bits from the code
m = [n_bin[2], n_bin[4], n_bin[5], n_bin[6], n_bin[8], n_bin[9], n_bin[10], n_bin[11]]
m_int = [int(x) for x in m]
c_old = [n_bin[0], n_bin[1], n_bin[3], n_bin[7]]
c_old = [int(x) for x in c_old]

# Continue formatting and display given number in binary
n_bin = n_bin[:4] + " " + n_bin[4:8] + " " + n_bin[8:12]
print(f'Your number in binary: {n_bin}')

# Calculate new check bits
c0 = m_int[0] ^ m_int[1] ^ m_int[3] ^ m_int[4] ^ m_int[6]
c1 = m_int[0] ^ m_int[2] ^ m_int[3] ^ m_int[5] ^ m_int[6]
c2 = m_int[1] ^ m_int[2] ^ m_int[3] ^ m_int[7]
c3 = m_int[4] ^ m_int[5] ^ m_int[6] ^ m_int[7]

# Display received and calculated check bits:
print(f'Received | Calculated check bits: ')
print(f'Cr0: {c_old[0]} | Cc0: {c0}\nCr1: {c_old[1]} | Cc1: {c1}\n'
      f'Cr2: {c_old[2]} | Cc2: {c2}\nCr3: {c_old[3]} | Cc3: {c3}\n')

# Calculate, form and display error syndrome and its decimal equivalent
error_syndrome = f'{c3 ^ c_old[3]}{c2 ^ c_old[2]}{c1 ^ c_old[1]}{c0 ^ c_old[0]}'
error_syndrome_decimal = int(error_syndrome, 2)
print(f'Error syndrome: {error_syndrome} ({error_syndrome_decimal})')

# Handle error syndrome
if error_syndrome_decimal > 11:
    print(f'Cannot resolve original message.')
elif error_syndrome_decimal == 0:
    print('Found no errors in the code.')
    # Format and display infromation bits
    m = m[::-1]
    m = ''.join(m)
    m_formatted = m[:4] + " " + m[4:]
    print(f'Original message was: {m_formatted} ({int(m, 2)})')
elif 0 < error_syndrome_decimal < 12:
    # Error syndrome 'points' at a check bit
    if error_syndrome_decimal in [1, 2, 4, 8]:
        print(f'Found an error in the code at position: {error_syndrome_decimal}.')
        print(f'This is a check bit that does not change information.')
        # Format and display infromation bits
        m = m[::-1]
        m = ''.join(m)
        m_formatted = m[:4] + " " + m[4:]
        print(f'Original message was: {m_formatted} ({int(m, 2)})')
    # Error syndrome 'points' at information bit
    else:
        print(f'Found an error in the code at position: {error_syndrome_decimal}.')
        # Correct the received code
        if int(n_bin_cpy[error_syndrome_decimal - 1]) == 0:
            n_bin_cpy = n_bin_cpy[:error_syndrome_decimal-1] + '1' + n_bin_cpy[error_syndrome_decimal:]
        else:
            n_bin_cpy = n_bin_cpy[:error_syndrome_decimal-1] + '0' + n_bin_cpy[error_syndrome_decimal:]
        # Format and display infromation bits
        m = m[::-1]
        m = ''.join(m)
        m_formatted = m[:4] + " " + m[4:]
        print(f'Received message was {m_formatted} ({int(m, 2)}).')
        m = [n_bin_cpy[2], n_bin_cpy[4], n_bin_cpy[5], n_bin_cpy[6],
            n_bin_cpy[8], n_bin_cpy[9], n_bin_cpy[10], n_bin_cpy[11]]
        m = m[::-1]
        m = ''.join(m)
        m_formatted = m[:4] + " " + m[4:]
        print(f'Corrected message is: {m_formatted} ({int(m, 2)})')
        print(f'Recevied code: {n_bin}')
        n_bin_cpy = n_bin_cpy[:4] + " " + n_bin_cpy[4:8] + " " + n_bin_cpy[8:12]
        print(f'Corrected code: {n_bin_cpy}')
