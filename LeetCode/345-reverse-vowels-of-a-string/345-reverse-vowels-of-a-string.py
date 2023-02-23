class Solution:
    def reverseVowels(self, s: str) -> str:

        characters = []

        for character in s:
            characters.append(character)
        
        ptr_left = 0
        ptr_right = len(characters) - 1

        while ptr_left < ptr_right:

            char_left = characters[ptr_left]
            char_right = characters[ptr_right]

            if not self.isVowel(char_left):
                ptr_left += 1
            if not self.isVowel(char_right):
                ptr_right -= 1
            if self.isVowel(char_left) and self.isVowel(char_right):
                temp = characters[ptr_left]
                characters[ptr_left] = characters[ptr_right]
                characters[ptr_right] = temp

                ptr_left += 1
                ptr_right -= 1
        return "".join(characters)

    def isVowel(self, character: str):
        print(character)
        return character in ("a", "A", "e", "E", "i", "I", "o", "O", "u", "U")