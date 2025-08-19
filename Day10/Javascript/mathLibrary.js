let x = 3.24;
let y = -7.89;

console.log("📘 Math Library Functions in JavaScript");

// ✅ Basic Rounding
console.log("1. Math.floor(x):", Math.floor(x));   // 3 → Rounds down
console.log("2. Math.ceil(x):", Math.ceil(x));     // 4 → Rounds up
console.log("3. Math.round(x):", Math.round(x));   // 3 → Nearest integer
console.log("4. Math.trunc(x):", Math.trunc(x));   // 3 → Removes decimal part

// ✅ Power & Roots
console.log("5. Math.pow(x, 2):", Math.pow(x, 2)); // x²
console.log("6. Math.sqrt(x):", Math.sqrt(x));     // Square root
console.log("7. Math.cbrt(x):", Math.cbrt(x));     // Cube root
console.log("8. Math.hypot(3,4):", Math.hypot(3,4)); // √(3²+4²)=5

// ✅ Absolute & Sign
console.log("9. Math.abs(y):", Math.abs(y));       // Absolute value
console.log("10. Math.sign(x):", Math.sign(x));    // 1 if +ve, -1 if -ve, 0 if 0

// ✅ Random & Min/Max
console.log("11. Math.random():", Math.random());  // Random (0–1)
console.log("12. Math.max(1,2,3,4,5):", Math.max(1,2,3,4,5));
console.log("13. Math.min(1,2,3,4,5):", Math.min(1,2,3,4,5));

// ✅ Logarithmic & Exponential
console.log("14. Math.log(x):", Math.log(x));      // Natural log (base e)
console.log("15. Math.log10(x):", Math.log10(x));  // Base 10 log
console.log("16. Math.log2(x):", Math.log2(x));    // Base 2 log
console.log("17. Math.exp(1):", Math.exp(1));      // e^1

// ✅ Trigonometry
console.log("18. Math.sin(x):", Math.sin(x));
console.log("19. Math.cos(x):", Math.cos(x));
console.log("20. Math.tan(x):", Math.tan(x));
console.log("21. Math.asin(0.5):", Math.asin(0.5)); // Inverse sine
console.log("22. Math.acos(0.5):", Math.acos(0.5)); // Inverse cosine
console.log("23. Math.atan(1):", Math.atan(1));     // Inverse tangent
console.log("24. Math.atan2(3,4):", Math.atan2(3,4)); // Angle y/x

// ✅ Hyperbolic Functions
console.log("25. Math.sinh(1):", Math.sinh(1));
console.log("26. Math.cosh(1):", Math.cosh(1));
console.log("27. Math.tanh(1):", Math.tanh(1));
console.log("28. Math.asinh(1):", Math.asinh(1));
console.log("29. Math.acosh(2):", Math.acosh(2));
console.log("30. Math.atanh(0.5):", Math.atanh(0.5));

// ✅ Rounding & Precision
console.log("31. Math.fround(x):", Math.fround(x)); // 32-bit float
console.log("32. Math.clz32(7):", Math.clz32(7));   // Leading zeros in 32-bit binary
console.log("33. Math.imul(2,4):", Math.imul(2,4)); // Fast 32-bit multiplication

// ✅ Constants
console.log("34. Math.PI:", Math.PI);               // π
console.log("35. Math.E:", Math.E);                 // Euler’s number
console.log("36. Math.SQRT2:", Math.SQRT2);         // √2
console.log("37. Math.SQRT1_2:", Math.SQRT1_2);     // √(1/2)
console.log("38. Math.LN2:", Math.LN2);             // ln(2)
console.log("39. Math.LN10:", Math.LN10);           // ln(10)
console.log("40. Math.LOG2E:", Math.LOG2E);         // log₂(e)
console.log("41. Math.LOG10E:", Math.LOG10E);       // log₁₀(e)
