class TimeLimitedCache {
  constructor() {
    this.cache = new Map(); // key -> { value, expiry }
  }

  set(key, value, duration) {
    const now = Date.now();
    const exists = this.cache.has(key) && this.cache.get(key).expiry > now;

    this.cache.set(key, {
      value,
      expiry: now + duration
    });

    return exists;
  }

  get(key) {
    const now = Date.now();
    if (!this.cache.has(key)) return -1;

    const { value, expiry } = this.cache.get(key);
    if (expiry <= now) {
      this.cache.delete(key);
      return -1;
    }
    return value;
  }

  count() {
    const now = Date.now();
    let validCount = 0;

    for (const [key, { expiry }] of this.cache.entries()) {
      if (expiry > now) {
        validCount++;
      } else {
        this.cache.delete(key); // cleanup expired
      }
    }

    return validCount;
  }
}
const cache = new TimeLimitedCache();

console.log(cache.set(1, 42, 100)); // false
setTimeout(() => console.log(cache.get(1)), 50); // 42
setTimeout(() => console.log(cache.count()), 50); // 1
setTimeout(() => console.log(cache.get(1)), 150); // -1