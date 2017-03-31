//
//  DatabaseManager.h
//  EventPal
//
//  Created by Yan Kononov on 29/03/2017.
//  Copyright © 2017 Yanislav Kononov. All rights reserved.
//

#import "Event.h"
#import "Location.h"
#import <Realm/Realm.h>
#import <Foundation/Foundation.h>


@interface DatabaseManager : NSObject
+ (_Nullable instancetype)sharedInstance;
- (void)saveInstance:(nonnull RLMObject *)object;
- (void) setupDatabase;
- ( RLMResults<Event*>* _Nullable )getEvents;
- (void) updateDatabase;
- (void)cleanDatabase;

@end
