package kodiak.core
package utils

given valueCanEqualValueOfSameType: [T] => CanEqual[T, T] = CanEqual.derived
