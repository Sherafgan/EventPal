//
//  Event.h
//  EventPal
//
//  Created by Yan Kononov on 29/03/2017.
//  Copyright © 2017 Yanislav Kononov. All rights reserved.
//

#import <UIKit/UIKit.h>
#import <Realm/Realm.h>
#import "Location.h"
#import <CoreLocation/CoreLocation.h>
#import <Foundation/Foundation.h>


@interface Event : RLMObject
@property (nonatomic, strong, nullable) NSString* name;
@property (nonatomic, strong, nullable) NSString* address;
@property (nonatomic, strong, nullable) Location* location;

+(nonnull instancetype) createEventNamed:(nonnull NSString*) name withAddress:(nonnull NSString*)address located:(nonnull Location*)location;
@end
