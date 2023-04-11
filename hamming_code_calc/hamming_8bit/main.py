##################################
# 12-bit Hamming Code Calculator #
# by Nikodem Przybyszewski       #
# Method according to UWM        #
# lecturers.                     #
##################################
from typing import List

n: int = -1
while n < 0 or n > 255:
    print("This calculator is designed for 8-bit numbers.\n\n")
    n = int(input('Enter a number (0 - 255): '))

# Tranform into binary
n_bin: str = bin(n)

# Format & display given number as binary
n_bin = n_bin.replace("0b", "")
while len(n_bin) < 8:
    n_bin = '0' + n_bin

n_bin = n_bin[:4] + " " + n_bin[4:]
n_bin_arr: List[int] = [int(x) for x in n_bin if x.isdigit()]
m = n_bin_arr[::-1]
print(f'Your number in binary: {n_bin}')

# Calculate check bits
c0: int = m[0] ^ m[1] ^ m[3] ^ m[4] ^ m[6]
c1: int = m[0] ^ m[2] ^ m[3] ^ m[5] ^ m[6]
c2: int = m[1] ^ m[2] ^ m[3] ^ m[7]
c3: int = m[4] ^ m[5] ^ m[6] ^ m[7]

# Display check bits
print(f'Check bits: ')
print(f'C0: {c0}\nC1: {c1}\nC2: {c2}\nC3: {c3}')

# Form, format & display Hamming code
hamming_formatted: str = f'{c0}{c1}{m[0]}{c2} {m[1]}{m[2]}{m[3]}{c3} {m[4]}{m[5]}{m[6]}{m[7]}'
hamming_no_spaces: str = f'{c0}{c1}{m[0]}{c2}{m[1]}{m[2]}{m[3]}{c3}{m[4]}{m[5]}{m[6]}{m[7]}'
print(f'Hamming code: {hamming_formatted}')
print(f'Hamming code in decimal: {int(hamming_no_spaces, 2)}')
