class Solution(object):
    def uniqueMorseRepresentations(self, words):
        v1 = ''
        v2 = ''
        dictslip = dict()
        dictfi = dict()
        dictstart = {'a': ".-", 'b': "-...", 'c': "-.-.", 'd': "-..", 'e': ".", 'f': "..-.", 'g': "--.", 'h': "....", 'i': "..", 'j': ".---", 'k': "-.-", 'l': ".-..", 'm': "--", 'n': "-.", 'o': "---", 'p': ".--.", 'q': "--.-", 'r': ".-.", 's': "...",'t': "-"
        , 'u': "..-", 'v': "...-", 'w': ".--", 'x': "-..-", 'y': "-.--", 'z': "--.."}
        for w_idx in words:
            #dictfi = dictslip.copy()
            # dictslip = ''
            for w_idx2 in w_idx:
                dictslip[w_idx2] = dictstart.get(w_idx2)
                v2 += dictstart.get(w_idx2)
            v1 = w_idx
            dictfi[v2] = v1
            v2 = ''
            v1 = ''
        print(dictfi)
        print(len(dictfi))
        return(len(dictfi))
solu = Solution()
solu.uniqueMorseRepresentations(["gin", "zen", "bla"])