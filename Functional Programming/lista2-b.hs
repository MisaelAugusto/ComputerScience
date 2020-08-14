import System.IO

-- 1
meuLast :: [Int] -> Int
meuLast [] = error "Lista vazia!"
meuLast xs | (tail xs) == [] = head xs
           | otherwise = meuLast (tail xs)

-- 2
penultimo :: [Int] -> Int
penultimo [] = error "Lista sem penultimo"
penultimo [head] = error "Lista sem penultimo"
penultimo xs | tail (tail xs) == [] = head xs
             | otherwise = penultimo (tail xs)

-- 3
elementAt :: Int -> [Int] -> Int
elementAt 1 xs = head xs
elementAt i xs = elementAt (i - 1) (tail xs)

-- 4
meuLength :: [t] -> Int
meuLength [] = 0
meuLength xs = 1 + meuLength (tail xs)

-- 5
meuReverso :: [Int] -> [Int]
meuReverso [] = []
meuReverso xs = meuReverso (tail xs) ++ [head xs]

-- 6
isPalindrome :: [Int] -> Bool
isPalindrome xs = xs == (meuReverso xs)

-- 7 *Considerar ordem dos elementos*
compress :: [Int] -> [Int]
compress [] = []
compress xs | elem (head xs) (tail xs) = compress (tail xs)
            | otherwise = [head xs] ++ compress (tail xs)

-- 8
compact :: [Int] -> [Int]
compact xs = undefined

-- 9
count :: Eq a => a -> [a] -> Int
count x = length . filter (x==)

encode :: [Int] -> [(Int, Int)]
encode xs = [(n, (count n xs)) | n <- (compress xs)]

-- 10
split :: [Int] -> Int -> [[Int], [Int]]
split [] _ = [[], []]
split xs i | i > 1 = [[head xs] ++ split (tail xs), _]
           | otherwise = []

main :: IO()
main = do
    print(meuLast [10..99])
    print(penultimo [1..2])
    print(elementAt 7 [3, 5..])
    print(meuLength [])
    print(meuReverso [1])
    print(isPalindrome [3, 2, 1, 1, 2, 3])
    print(compress [2, 2, 3, 5, 3, 5, 7, 8, 0, 1, 7])
    print(compress [1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 4, 3, 4, 5, 1, 1, 2, 3, 3, 1])
    print(encode [1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 4, 3, 4, 5, 1, 1, 2, 3, 3, 1])
    
    
