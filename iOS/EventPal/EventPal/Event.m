//
//  Event.m
//  EventPal
//
//  Created by Yan Kononov on 29/03/2017.
//  Copyright © 2017 Yanislav Kononov. All rights reserved.
//

#import "Event.h"

@implementation Event
+(nonnull instancetype) createEventNamed:(nonnull NSString*) name withAddress:(nonnull NSString*)address located:(nonnull Location*)location
{
    Event* event = [[Event alloc] init];
    event.name = name;
    event.address = address;
    event.location = location;
    return event;
};
+ (NSString *)primaryKey {
    return @"address";
}

@end
