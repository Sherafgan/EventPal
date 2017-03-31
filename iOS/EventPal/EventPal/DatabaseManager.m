//
//  DatabaseManager.m
//  EventPal
//
//  Created by Yan Kononov on 29/03/2017.
//  Copyright © 2017 Yanislav Kononov. All rights reserved.
//

#import "DatabaseManager.h"

@implementation DatabaseManager

+ (instancetype)sharedInstance
{
    //we will reuse this only object over and over again so that's why it's singleton
    static id sharedInstance = nil;
    static dispatch_once_t pred;
    dispatch_once(&pred, ^{
        sharedInstance = [[super alloc] init];
    });
    
    return sharedInstance;
}


- (void)saveInstance:(nonnull RLMObject *)object // wrapped writeTransaction method
{
    RLMRealm *realm = [RLMRealm defaultRealm];
    [realm beginWriteTransaction];
    [realm addOrUpdateObject:object];
    [realm commitWriteTransaction];
}
- ( RLMResults<Event*>* _Nullable )getEvents
{
    return [Event allObjects];
};


- (void) updateDatabase
{
    [self cleanDatabase];
    NSArray<NSString*> *names = @[@"Steak party",@"iOS Meetup",@"Android Conference",@"Digital Future",@"Innopolis promotion",@"Help childrens of Africa",@"Jimmy Kimmel Late Night",@"President press-conference",@"Restraunt Bordeaux opening",@"Night party",@"Crazy pranks",@"Steak party",@"iOS Meetup",@"Android Conference",@"Digital Future",@"Innopolis promotion",@"Help childrens of Africa",@"Jimmy Kimmel Late Night",@"President press-conference",@"Restraunt Bordeaux opening",@"Night party",@"Crazy pranks",@"Steak party",@"iOS Meetup",@"Android Conference",@"Digital Future",@"Innopolis promotion",@"Help childrens of Africa",@"Jimmy Kimmel Late Night",@"President press-conference",@"Restraunt Bordeaux opening"];
    NSArray<NSString*> *addresses = @[@"1",@"2",@"3",@"4",@"5",@"6",@"7",@"8",@"9",@"10",@"11",@"12",@"13",@"14",@"15",@"16",@"17",@"18",@"19",@"20",@"21",@"22",@"23",@"24",@"25",@"26",@"27",@"28",@"29",@"30",@"31"];
    NSArray<Location*> *locations = @[[[Location alloc] initWithLatitude:55.738707 longitude:37.410790],//1
                                      [[Location alloc] initWithLatitude:55.744119 longitude:37.508723],//2
                                      [[Location alloc] initWithLatitude:55.789856 longitude:37.533957],//3
                                      [[Location alloc] initWithLatitude:55.803740 longitude:37.618972],//4
                                      [[Location alloc] initWithLatitude:55.785585 longitude:37.666007],
                                      [[Location alloc] initWithLatitude:55.704687 longitude:37.642919],//6
                                      [[Location alloc] initWithLatitude:55.800702 longitude: 37.563312],
                                      [[Location alloc] initWithLatitude:55.812290 longitude:37.653263],//8
                                      [[Location alloc] initWithLatitude:55.788639 longitude:37.715683],
                                      [[Location alloc] initWithLatitude:55.740025 longitude:37.665300],//10
                                      [[Location alloc] initWithLatitude:55.848186 longitude:37.487953],
                                      [[Location alloc] initWithLatitude:55.740758 longitude:37.552884],//12
                                      [[Location alloc] initWithLatitude:55.753455 longitude:337.523064],
                                      [[Location alloc] initWithLatitude:55.824458 longitude:37.529389],//14
                                      [[Location alloc] initWithLatitude:55.683253 longitude:37.755253],
                                      [[Location alloc] initWithLatitude:55.787235 longitude:37.480742],//16
                                      [[Location alloc] initWithLatitude:55.814034 longitude:37.467932],
                                      [[Location alloc] initWithLatitude:55.719643 longitude:37.418620],//18
                                      [[Location alloc] initWithLatitude:55.708947 longitude:37.361776],
                                      [[Location alloc] initWithLatitude:55.688414 longitude:37.394565],//20
                                      [[Location alloc] initWithLatitude:55.750924 longitude:37.412591],
                                      [[Location alloc] initWithLatitude:55.724444 longitude:37.577418],//22
                                      [[Location alloc] initWithLatitude:55.761722 longitude:37.572225],
                                      [[Location alloc] initWithLatitude:55.775338 longitude:37.589058],
                                      [[Location alloc] initWithLatitude:55.797016 longitude:37.541186],
                                      [[Location alloc] initWithLatitude:55.801997 longitude:37.508184],
                                      [[Location alloc] initWithLatitude:55.754263 longitude:37.533922],
                                      [[Location alloc] initWithLatitude:55.802522 longitude:37.631519],
                                      [[Location alloc] initWithLatitude:55.842108 longitude:37.569721],
                                      [[Location alloc] initWithLatitude:55.807951 longitude:37.57912],
                                      [[Location alloc] initWithLatitude:55.792537 longitude:37.579209]];
    NSLog(@"%lu", (unsigned long)[names count]);
    NSLog(@"%lu", (unsigned long)[addresses count]);
    NSLog(@"%lu", (unsigned long)[locations count]);
    for(int i = 0;i < [names count]; i++)
    {
        Event* event = [Event createEventNamed:names[i] withAddress:addresses[i] located:locations[i]];
        [self saveInstance:event];
    }
};

-(void) setupDatabase
{
    //set here sort/search criterias that you want to see at the start
    
}

- (void)cleanDatabase
{
    //completely erases all the data stored in the database
    RLMRealm *realm = [RLMRealm defaultRealm];
    [realm beginWriteTransaction];
    [realm deleteAllObjects];
    [realm commitWriteTransaction];
    
}

@end
