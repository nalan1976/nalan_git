class Solution(object):
    def canConstruct(self, ransomNote, magazine):
        i = 0
        if len(magazine) == 0 or len(magazine) < len(ransomNote):
            if len(magazine) == 0 and len(ransomNote) == 0:
                print(True)
                return True
            print(False)
            return False
        while len(ransomNote) != 0:
            for j in range(0, len(magazine)):
                # if magazine[j] == ransomNote[i]:
                #     magazine = magazine[0: j] + magazine[j+1:]
                #     ransomNote = ransomNote[0: i] + ransomNote[i+1:]
                if magazine[j] == ransomNote[0]:
                    magazine = magazine[0: j] + magazine[j+1:]
                    ransomNote = ransomNote[0: 0] + ransomNote[0+1:]
                    break
                if j == len(magazine) - 1:
                    print(False)
                    return False
        print(True)
        return True
solu = Solution()
solu.canConstruct("a", "b")
solu.canConstruct("aa", "ab")
solu.canConstruct("aa", "aab")
solu.canConstruct("bg", "adnhcohvogajudvnabssfagufonc")
solu.canConstruct("", "")
solu.canConstruct("bg", "")
solu.canConstruct("ab", "cav")
