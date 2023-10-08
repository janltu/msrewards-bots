#pragma once

// Unsigned int types.
typedef unsigned char u8;
typedef unsigned short u16;
typedef unsigned int u32;
typedef unsigned long long u64;

// Signed int types.
typedef signed char i8;
typedef signed short i16;
typedef signed int i32;
typedef signed long long i64;

// Floating point types
typedef float f32;
typedef double f64;

// Boolean types
typedef int b32;
typedef char b8;


// Properly define static assertions.
#if defined(__clang__) || defined(__gcc__)
#define STATIC_ASSERT _Static_assert
#else
#define STATIC_ASSERT static_assert
#endif


// Ensure all types are of the correct size.
STATIC_ASSERT(sizeof(u8) == 1, "Expected u8 to be 1 byte.");
STATIC_ASSERT(sizeof(u16) == 2, "Expected u16 to be 2 bytes.");
STATIC_ASSERT(sizeof(u32) == 4, "Expected u32 to be 4 bytes.");
STATIC_ASSERT(sizeof(u64) == 8, "Expected u64 to be 8 bytes.");

STATIC_ASSERT(sizeof(i8) == 1, "Expected i8 to be 1 byte.");
STATIC_ASSERT(sizeof(i16) == 2, "Expected i16 to be 2 bytes.");
STATIC_ASSERT(sizeof(i32) == 4, "Expected i32 to be 4 bytes.");
STATIC_ASSERT(sizeof(i64) == 8, "Expected i64 to be 8 bytes.");

STATIC_ASSERT(sizeof(f32) == 4, "Expected f32 to be 4 bytes.");
STATIC_ASSERT(sizeof(f64) == 8, "Expected f64 to be 8 bytes.");

#define TRUE 1
#define FALSE 0


//// Exports / Imports
#ifdef CeEXPORT
// Exports
#ifdef _MSC_VER
#define CeAPI __declspec(dllexport)
#else
#define CeAPI __attribute__((visibility("default")))
#endif
#else
// Imports
#ifdef _MSC_VER
#define CeAPI __declspec(dllimport)
#else
#define CeAPI
#endif
#endif


// Platform detection (Defines for platforms):
//
// CePLATFORM_WINDOWS
// CePLATFORM_LINUX
// CePLATFORM_ANDROID
// CePLATFORM_UNIX
// CePLATFORM_POSIX
// CePLATFORM_APPLE: 
//      CePLATFORM_IOS
//      CePLATFORM_IOS_SIMULATOR

// Windows
#if defined(WIN32) || defined(_WIN32) || defined(__WIN32__) 

#define CePLATFORM_WINDOWS 1
#ifndef _WIN64
#error "64-bit is required on Windows!"
#endif

// Linux OS
#elif defined(__linux__) || defined(__gnu_linux__)

#define CePLATFORM_LINUX 1
#if defined(__ANDROID__)
#define CePLATFORM_ANDROID 1
#endif

// Catch anything not caught by the above.
#elif defined(__unix__)

#define CePLATFORM_UNIX 1
#elif defined(_POSIX_VERSION)
#define CePLATFORM_POSIX 1

// Apple platforms
#elif __APPLE__

#define CePLATFORM_APPLE 1
#include <TargetConditionals.h>
#if TARGET_IPHONE_SIMULATOR
#define CePLATFORM_IOS 1
#define CePLATFORM_IOS_SIMULATOR 1
#elif TARGET_OS_IPHONE
#define CePLATFORM_IOS 1


#elif TARGET_OS_MAC
// Other kinds of Mac OS
#else
#error "Unknown Apple platform"
#endif

#else
#error "Unknown platform!"
#endif
