# Given two strings s and t, write a
# function to determine if t is an anagram of s.
#
# Example 1:
# Input: s = "anagram", t = "nagaram"
# Output: true
#
# Example 2:
# Input: s = "rat", t = "car"
# Output: false


class Solution(object):
    def isAnagram(self, s, t):
        if len(s) != len(t):
            print(False)
            return False
        list1 = list()
        list2 = list()
        for i in range(0, len(s)):
            list1.append(s[i])
            list2.append(t[i])
        if sorted(list1) == sorted(list2):
            print(True)
            return True
        print(False)
        return False
solu= Solution()
solu.isAnagram("anagram", "nagaram")
solu.isAnagram("fkga", "fvst")