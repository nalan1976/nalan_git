# Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
#
# Examples:
#
# s = "leetcode"
# return 0.
#
# s = "loveleetcode",
# return 2.
class Solution(object):
    def firstUniqChar(self, s):
        count = 0
        for i in range(0, len(s)):
            count = 0
            for j in range(0, len(s)):
                if s[j] == s[i]:
                    count += 1
                if count >= 2:
                    break
            if count == 1:
                print(i)
                return i
        print(-1)
        return -1
solu = Solution()
# solu.firstUniqChar("leetcode")
solu.firstUniqChar("loveleetcode")

"sdnvlbkrmtbollujsdjfjfppksravjkwwsimlmdtcmiilpjibjhcppluisqbqfwrjjlrapsmcwrsrnfrmtjrffpuuqwonqfjfqxellpvmcfmhxccljqlvboioelpfcawrxlwsajfaiehutvogduhobwgpogvatpbvoaognbepqnkhkjsvqmfaghavopppcjbjunuaeotpkbfsmeqikjflakgjexnqqgxnsdjolbjbvhreighxhkihwphexwqufasjakmrdrpwciefaiqsaifmcfdeidhmjekoorvcuxtejlrfscrjekfkcnsdhhsxenhkuanafdpnsjnepdmvvrhbxwuhmrkenrcwbadsiulpvcklhlburudrbbskokwnwqktwjxstsvebvpqcugxjebcivudojorntphtscxhoxlhteuqunhvrsndtabfpdqdcsuqmdbeiiexdkaqtgkncfatlawrudbausifpsicibgrwastcxkjasmrmtrchbwlkxnbsxeaurtfdwmjqkgikcctgccsisgwlkkwflvahasltfusxogtbejrderxbqshacgsrvtqpgdcwmuwuejcmqanirwthsaxihlowgwjeegdltsujtrfuhjnqjjefqjwubiktuglirmgcdqfolvmrilkrvtlrtntujffbrtfiwdtvtfrkfnwklfulecxtkvqpgcrqvgjxbebjlbiopbnhqbdhhxsmgpdojhupxnfkmqsjlmcserhsiwhvelcufuvqrvpwhckexvutuwgfbgnqsmpmfuqkrvwggskovlqtqnqxvpghqoomplnnkmuhkbwpaxuhrkphbgwopxikisuegmxhbjocwhumauhiegojccvibwfdrdnahnwduvnuxjcuncrcgwwrjhxmdemnuxcjspjisgduuoojpxluvehoqpctncxniatxqckhmggtwgjihfnxdhbjwjhuqwuoveibqppqrmxrmaddukgcxpub
